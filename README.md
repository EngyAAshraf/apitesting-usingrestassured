# api-automation

api-automation is a test automation project for all APIs. It comprises several test runners to cater for 
different test scenarios in different environments.

## Prerequisites
- Java JDK 17
- Maven 3.8.6

## Installation

Navigate to the root directory of the project and perform a clean maven install.

```bash
mvn clean install -DskipTests
```

## Usage
Navigate to `/runner` directory, then execute the desired profile.

```bash
mvn clean test -P${profileName}
```
The default environment is pre-configured to test.

It is possible to change the environment by providing the `environment` argument

```bash
mvn clean test -P${profileName} -Denvironment=${environment}
```

## Profiles List
- [reqresInFlow]()


## Environment Mapping
| environment | portal | status |
|:-----------:|:------:|:------:|


## Common Build Issues
Running the project from the command line could sometimes generate build failures, yet the test suite could be 
running fine from within the IDE. This issue occurs when the local maven repository needs to be updated.

Performing a clean install once again on the root directory will solve the issue.
```bash
mvn clean install -DskipTests
```

## Contributing
### Dependency Management
Make sure to create a new module for each portal/app. All modules should be added to the `dependencyManagement` tag 
in the parent `POM.xml` file.

```xml
<dependencyMangement>
    <dependency>
        <groupId>org.example</groupId>
        <artifactId>${moduleName}</artifactId>
        <version>1.0-SNAPSHOT</version>
        <scope>test</scope>
    </dependency> 
</dependencyMangement>
```
Subsequently, add the `framework` dependencies to the `POM.xml` file of the new module.
```xml
<dependencies>
    <dependency>
        <groupId>org.example</groupId>
        <artifactId>framework</artifactId>
    </dependency>
    <dependency>
        <groupId>org.example</groupId>
        <artifactId>framework</artifactId>
        <version>1.0-SNAPSHOT</version>
        <type>test-jar</type>
    </dependency>
</dependencies>
```
Finally, add the new module as a dependency in the `POM.xml` file of the `runner` module.
```xml
<dependency>
    <groupId>org.example</groupId>
    <artifactId>${moduleName}</artifactId>
    <version>1.0-SNAPSHOT</version>
    <type>test-jar</type>
</dependency>
```

### Creating Profiles and Test Runners
Create a new `${testng}.xml` file for each test suite, making sure that the name reflects the purpose of the suite.
Afterwards, add a name for the profile inside the created `${testng}.xml` file.

```xml
<suite name="${profileId}"/>
```
The file should be placed in the root directory of the `runner` module, and referenced in the `POM.xml` file of said
module inside the `profiles` tag.

```xml
<profiles>
    <profile>
        <id>${profileId}</id>
        <properties>
            <testNGSuite>${testng}.xml</testNGSuite>
        </properties>
    </profile>
</profiles>
```

### Reusable Variables
Static variables should be placed in the `framework` module, inside `src/main/staticVariables` directory.
Make sure to create a new class for each entity.

### Test Data Generation
Creating random data for testing purposes can be achieved through `DataGenerator` class, which is located
in the `framework` module under `src/main/dataHelper`.

Create a new method inside the `DataGenerator` class whenever a new variable type is needed.

### Naming Convention
The framework follows the standard Java naming conventions:
- Modules:  kebab case
- Packages: camel case
- Classes: pascal case
- Methods: camel case
- Variables: camel case
- Constants: uppercase snake case 
