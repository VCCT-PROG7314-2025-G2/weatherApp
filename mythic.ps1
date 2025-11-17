# Mythic C2 + HackerGPT Setup on Windows
# Run this in PowerShell as Administrator

Write-Host "[*] Updating system and installing dependencies..."

# Install Chocolatey if not installed
if (-Not (Get-Command choco -ErrorAction SilentlyContinue)) {
    Set-ExecutionPolicy Bypass -Scope Process -Force
    iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))
}

# Install required packages
choco install -y git docker-desktop python python3

Write-Host "[*] Cloning Mythic..."
cd $env:USERPROFILE
git clone https://github.com/its-a-feature/Mythic.git
cd Mythic

Write-Host "[*] Configuring Docker..."
Start-Process "C:\Program Files\Docker\Docker\Docker Desktop.exe"
Start-Sleep -Seconds 15

# Enable WSL2 backend for Docker
wsl --install -d Ubuntu
wsl --set-default-version 2

Write-Host "[*] Installing Mythic CLI..."
wsl bash -c "cd /mnt/c/Users/$env:USERNAME/Mythic && sudo ./mythic-cli install"

Write-Host "[*] Adding HackerGPT plugin..."
$pluginPath = "$env:USERPROFILE\Mythic\mythic_plugins\hackergpt"
New-Item -ItemType Directory -Force -Path $pluginPath | Out-Null

$hackergptCode = @"
from mythic_container.MythicCommandBase import *
import openai, os

class HackerGPTCommand(CommandBase):
    cmd = "hackergpt"
    needs_admin = False
    help_cmd = "hackergpt {query}"
    description = "Ask HackerGPT for exploit/payload help"
    version = 1

    async def create_tasking(self, task: PTTaskMessage) -> PTTaskCreateTaskingMessageResponse:
        query = task.args.get_arg("query")
        openai.api_key = os.getenv("HACKER_GPT_KEY")

        resp = openai.ChatCompletion.create(
            model="gpt-5",
            messages=[{"role": "system", "content": "You are HackerGPT-2, a pentest assistant."},
                      {"role": "user", "content": query}]
        )

        answer = resp["choices"][0]["message"]["content"]
        return PTTaskCreateTaskingMessageResponse(TaskResponse=answer)
"@

Set-Content -Path "$pluginPath\hackergpt.py" -Value $hackergptCode

Write-Host "[*] Setup complete!"
Write-Host "Next steps:"
Write-Host "1. Set your HackerGPT API key in PowerShell:  setx HACKER_GPT_KEY 'sk-xxxx'"
Write-Host "2. Start Mythic inside WSL:  wsl cd /mnt/c/Users/$env:USERNAME/Mythic && ./mythic-cli start"
Write-Host "3. Access Mythic UI at:  https://127.0.0.1:7443"
Write-Host "4. Login (default: mythic_admin / mythic_password)"
Write-Host "5. Use 'hackergpt' command in Mythic to ask GPT for exploits/payloads."
