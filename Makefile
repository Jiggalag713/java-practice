build:
	bash gradlew clean && bash gradlew build

test:
	bash gradlew clean && bash gradlew test

test-n-report:
	bash gradlew clean && bash gradlew allureServe --depends-on-tests