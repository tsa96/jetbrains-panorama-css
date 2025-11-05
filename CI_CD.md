# CI/CD Documentation

## Overview

This project uses GitHub Actions for continuous integration and deployment. The CI/CD pipeline automatically builds, tests, and releases the plugin.

## Workflows

### 1. Build Plugin (`build.yml`)

**Triggers:**
- Push to `main` or `develop` branches
- Pull requests to `main`
- Manual workflow dispatch

**Jobs:**

#### Build Job
- Checks out code
- Sets up Java 17 with Gradle caching
- Builds the plugin with `./gradlew build`
- Runs tests with `./gradlew test`
- Creates plugin distribution with `./gradlew buildPlugin`
- Uploads build artifacts (plugin ZIP and reports)

#### Verify Job
- Runs after successful build
- Verifies plugin structure with `./gradlew verifyPlugin`
- Runs IntelliJ Plugin Verifier to check compatibility

**Artifacts:**
- `plugin-distribution`: Plugin ZIP file (retained for 30 days)
- `build-reports`: Test results and build reports (retained for 7 days)

### 2. Release Plugin (`release.yml`)

**Triggers:**
- Push of tags matching `v*` (e.g., `v1.0.0`)
- Manual workflow dispatch with version input

**Jobs:**

#### Release Job
- Builds the plugin
- Creates a GitHub Release with:
  - Plugin ZIP file attached
  - Formatted release notes
  - Installation instructions
  - Version information

#### Publish to Marketplace Job
- Runs after successful release (tag pushes only)
- Publishes plugin to JetBrains Marketplace
- Requires `JETBRAINS_MARKETPLACE_TOKEN` secret

### 3. Code Quality (`quality.yml`)

**Triggers:**
- Push to `main` or `develop` branches
- Pull requests to `main`
- Manual workflow dispatch

**Jobs:**

#### Lint Job
- Runs ktlint for Kotlin code formatting (if configured)
- Runs detekt for static analysis (if configured)
- Both continue on error if not configured

#### Validate Job
- Validates Gradle wrapper integrity
- Validates `plugin.xml` structure
- Validates `panorama-css-data.json` as valid JSON
- Checks for TODO/FIXME comments
- Verifies file encodings

## Dependabot

Automated dependency updates via `.github/dependabot.yml`:

- **GitHub Actions**: Weekly updates for workflow actions
- **Gradle Dependencies**: Weekly updates for project dependencies
- **Ignored**: Major version updates for Kotlin and IntelliJ Plugin (require manual review)

## Secrets Configuration

### Required Secrets

To enable full CI/CD functionality, configure these secrets in GitHub repository settings:

#### For Releases to JetBrains Marketplace

1. **`JETBRAINS_MARKETPLACE_TOKEN`**
   - Obtain from: https://plugins.jetbrains.com/author/me/tokens
   - Used by: `release.yml` workflow
   - Purpose: Publishing plugin to JetBrains Marketplace

#### For Plugin Signing (Optional)

2. **`CERTIFICATE_CHAIN`**
   - Plugin signing certificate chain
   - Used by: Build process if available

3. **`PRIVATE_KEY`**
   - Plugin signing private key
   - Used by: Build process if available

4. **`PRIVATE_KEY_PASSWORD`**
   - Password for private key
   - Used by: Build process if available

### Setting Secrets

```bash
# In GitHub repository:
Settings → Secrets and variables → Actions → New repository secret
```

## Creating a Release

### Automated Release (Recommended)

1. Update version in `build.gradle.kts`:
   ```kotlin
   version = "1.0.1"
   ```

2. Commit and push:
   ```bash
   git add build.gradle.kts
   git commit -m "chore: bump version to 1.0.1"
   git push
   ```

3. Create and push a tag:
   ```bash
   git tag v1.0.1
   git push origin v1.0.1
   ```

4. GitHub Actions will automatically:
   - Build the plugin
   - Create a GitHub Release
   - Publish to JetBrains Marketplace (if token is configured)

### Manual Release

Trigger manually from GitHub Actions:

1. Go to Actions → Release Plugin → Run workflow
2. Enter version number (e.g., `1.0.1`)
3. Click "Run workflow"

## Build Status Badges

Add these badges to README.md (already included):

```markdown
[![Build Plugin](https://github.com/tsa96/jetbrains-panorama-css/actions/workflows/build.yml/badge.svg)](https://github.com/tsa96/jetbrains-panorama-css/actions/workflows/build.yml)
[![Code Quality](https://github.com/tsa96/jetbrains-panorama-css/actions/workflows/quality.yml/badge.svg)](https://github.com/tsa96/jetbrains-panorama-css/actions/workflows/quality.yml)
```

## Local Testing

Before pushing, test builds locally:

```bash
# Build plugin
./gradlew build

# Run in IDE sandbox
./gradlew runIde

# Build distribution
./gradlew buildPlugin

# Verify plugin
./gradlew verifyPlugin
```

## Troubleshooting

### Build Fails on CI but Works Locally

1. **Check Java version**: CI uses Java 17, ensure compatibility
2. **Check Gradle wrapper**: Ensure `gradle/wrapper` is committed
3. **Check dependencies**: CI downloads fresh dependencies each time
4. **Check file paths**: Use forward slashes, not backslashes

### Release Job Fails

1. **Tag format**: Tags must match `v*` (e.g., `v1.0.0`, not `1.0.0`)
2. **Permissions**: Check Actions permissions in repository settings
3. **Secrets**: Verify `JETBRAINS_MARKETPLACE_TOKEN` is set correctly

### Marketplace Publishing Fails

1. **Token validity**: Regenerate token if expired
2. **Plugin ID**: Ensure `plugin.xml` ID matches marketplace registration
3. **Compatibility**: Check IntelliJ version compatibility settings

## Workflow Logs

View detailed logs:
1. Go to Actions tab in GitHub
2. Click on a workflow run
3. Click on a job to see detailed logs
4. Download artifacts if needed

## Best Practices

1. **Always test locally first** before pushing
2. **Use semantic versioning** for releases (MAJOR.MINOR.PATCH)
3. **Update CHANGELOG** before creating releases
4. **Review Dependabot PRs** promptly for security updates
5. **Monitor build status** via badges and email notifications
6. **Test releases** in a sandbox IDE before public release

## Continuous Improvement

Consider adding:
- Code coverage reporting (JaCoCo)
- Security scanning (Snyk, CodeQL)
- Performance benchmarking
- Automated changelog generation
- Slack/Discord notifications for releases

## Resources

- [GitHub Actions Documentation](https://docs.github.com/en/actions)
- [IntelliJ Platform Plugin Development](https://plugins.jetbrains.com/docs/intellij/)
- [Gradle IntelliJ Plugin](https://github.com/JetBrains/gradle-intellij-plugin)
- [JetBrains Marketplace](https://plugins.jetbrains.com/)
