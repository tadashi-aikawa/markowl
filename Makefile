MAKEFLAGS += --warn-undefined-variables
.DEFAULT_GOAL := help

#------

.PHONY: help
help: ## Print Help
	@"awk" 'BEGIN {FS = ":.*?## "} /^[a-zA-Z0-9][a-zA-Z0-9_-]+:.*?## / {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}' $(MAKEFILE_LIST)

guard-%:
	powershell if ( '$($*)' -eq '' ) {\
		echo '[ERROR] $* is required!!';\
		exit 1;\
	}

#------

.PHONY: release
release: guard-version build ## make release version=x.y.z
	@echo 1. Preincrement version
	@sed -ri "s/^version .+/version '$(version)'/g" build.gradle

	@echo 2. Build
	@gradlew.bat buildPlugin

	@echo 3. Commit
	@git add build.gradle
	@git commit -m ":package: Version $(version)"

	@echo 4. Tagged
	git tag v$(version) -m v$(version)

	@echo 5. Push
	@git push --tags
	@git push

	@echo "All Successed!!"
	@echo "Upload build/distributions/markowl-$(version).zip to https://plugins.jetbrains.com/plugin/edit?pluginId=14116"
