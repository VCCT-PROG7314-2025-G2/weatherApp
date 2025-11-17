# PowerShell Script to Sync Improvements with Existing GitHub Repository
# Run this script from: C:\Users\Administrator\Desktop\weatherapp_p2

Write-Host "=== Syncing Improvements with GitHub Repository ===" -ForegroundColor Cyan
Write-Host ""

# Step 1: Navigate to Desktop
Write-Host "Step 1: Navigating to Desktop..." -ForegroundColor Yellow
cd C:\Users\Administrator\Desktop

# Step 2: Clone the existing repository
Write-Host "Step 2: Cloning existing GitHub repository..." -ForegroundColor Yellow
if (Test-Path "weatherApp_github") {
    Write-Host "  Folder already exists. Removing..." -ForegroundColor Gray
    Remove-Item -Path "weatherApp_github" -Recurse -Force
}
git clone https://github.com/VCCT-PROG7314-2025-G2/weatherApp.git weatherApp_github
if ($LASTEXITCODE -ne 0) {
    Write-Host "  ERROR: Failed to clone repository" -ForegroundColor Red
    exit 1
}
Write-Host "  ✓ Repository cloned successfully" -ForegroundColor Green

# Step 3: Copy improvements
Write-Host "Step 3: Copying your improvements..." -ForegroundColor Yellow
cd weatherApp_github

# Copy GitHub Actions workflow
if (Test-Path "..\weatherapp_p2\.github") {
    Copy-Item -Path "..\weatherapp_p2\.github" -Destination "." -Recurse -Force
    Write-Host "  ✓ GitHub Actions workflow copied" -ForegroundColor Green
}

# Copy .gitignore
if (Test-Path "..\weatherapp_p2\.gitignore") {
    Copy-Item -Path "..\weatherapp_p2\.gitignore" -Destination "." -Force
    Write-Host "  ✓ .gitignore copied" -ForegroundColor Green
}

# Copy unit tests
if (Test-Path "..\weatherapp_p2\app\src\test") {
    if (-not (Test-Path "app\src\test")) {
        New-Item -ItemType Directory -Path "app\src\test" -Force | Out-Null
    }
    Copy-Item -Path "..\weatherapp_p2\app\src\test" -Destination "app\src\" -Recurse -Force
    Write-Host "  ✓ Unit tests copied" -ForegroundColor Green
}

# Copy documentation files
$docs = @(
    "PROJECT_STRUCTURE.md",
    "CONTRIBUTING.md",
    "IMPROVEMENTS_SUMMARY.md",
    "REQUIREMENTS_COMPLIANCE_REPORT.md",
    "GITHUB_PUSH_GUIDE.md",
    "CHANGES_SUMMARY.md",
    "SYNC_WITH_EXISTING_REPO.md",
    "STEP_BY_STEP_SYNC.md",
    "README_PUSH_INSTRUCTIONS.md"
)

foreach ($doc in $docs) {
    if (Test-Path "..\weatherapp_p2\$doc") {
        Copy-Item -Path "..\weatherapp_p2\$doc" -Destination "." -Force
        Write-Host "  ✓ $doc copied" -ForegroundColor Green
    }
}

# Copy updated README
if (Test-Path "..\weatherapp_p2\README.md") {
    Copy-Item -Path "..\weatherapp_p2\README.md" -Destination "." -Force
    Write-Host "  ✓ README.md updated" -ForegroundColor Green
}

# Copy updated build.gradle (merge test dependencies)
if (Test-Path "..\weatherapp_p2\app\build.gradle") {
    # Backup original
    Copy-Item -Path "app\build.gradle" -Destination "app\build.gradle.backup" -Force
    # Copy improved version
    Copy-Item -Path "..\weatherapp_p2\app\build.gradle" -Destination "app\" -Force
    Write-Host "  ✓ build.gradle updated (backup saved as build.gradle.backup)" -ForegroundColor Green
}

# Copy enhanced source files with comments
if (Test-Path "..\weatherapp_p2\app\src\main\java\com\weatherapp") {
    $sourceFiles = @(
        "viewmodel\WeatherViewModel.kt",
        "data\auth\AuthManager.kt",
        "data\api\ApiConfig.kt"
    )
    foreach ($file in $sourceFiles) {
        $sourcePath = "..\weatherapp_p2\app\src\main\java\com\weatherapp\$file"
        $destPath = "app\src\main\java\com\weatherapp\$file"
        if (Test-Path $sourcePath) {
            Copy-Item -Path $sourcePath -Destination $destPath -Force
            Write-Host "  ✓ $file updated with enhanced comments" -ForegroundColor Green
        }
    }
}

Write-Host ""
Write-Host "Step 4: Checking git status..." -ForegroundColor Yellow
git status

Write-Host ""
Write-Host "=== Ready to Commit and Push ===" -ForegroundColor Cyan
Write-Host ""
Write-Host "Next steps:" -ForegroundColor Yellow
Write-Host "1. Review the changes: git status" -ForegroundColor White
Write-Host "2. Stage all changes: git add ." -ForegroundColor White
Write-Host "3. Commit: git commit -m 'Add CI/CD, unit tests, enhanced docs'" -ForegroundColor White
Write-Host "4. Push: git push origin main" -ForegroundColor White
Write-Host ""
Write-Host "Or run these commands now? (Y/N)" -ForegroundColor Yellow
$response = Read-Host

if ($response -eq "Y" -or $response -eq "y") {
    Write-Host ""
    Write-Host "Staging changes..." -ForegroundColor Yellow
    git add .
    
    Write-Host "Committing..." -ForegroundColor Yellow
    git commit -m "Add CI/CD pipeline, unit tests, enhanced documentation

- Added GitHub Actions workflow for automated builds and tests
- Implemented unit tests for ViewModel, AuthManager, and Repository
- Enhanced code comments and documentation
- Added comprehensive .gitignore
- Created additional documentation files
- Updated README with correct repository information
- All mandatory prototype requirements now met"
    
    Write-Host ""
    Write-Host "Pushing to GitHub..." -ForegroundColor Yellow
    Write-Host "You may be prompted for GitHub credentials." -ForegroundColor Gray
    git push origin main
    
    if ($LASTEXITCODE -eq 0) {
        Write-Host ""
        Write-Host "=== SUCCESS! ===" -ForegroundColor Green
        Write-Host "Your improvements have been pushed to GitHub!" -ForegroundColor Green
        Write-Host "Visit: https://github.com/VCCT-PROG7314-2025-G2/weatherApp" -ForegroundColor Cyan
    } else {
        Write-Host ""
        Write-Host "Push failed. You may need to:" -ForegroundColor Red
        Write-Host "1. Set up GitHub authentication" -ForegroundColor Yellow
        Write-Host "2. Use a Personal Access Token" -ForegroundColor Yellow
        Write-Host "3. Or push manually using the commands above" -ForegroundColor Yellow
    }
} else {
    Write-Host ""
    Write-Host "Changes are ready. Run the git commands manually when ready." -ForegroundColor Cyan
}

Write-Host ""
Write-Host "Script completed!" -ForegroundColor Green

