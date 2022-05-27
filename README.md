Coverage: 72%
# Project Title

One Paragraph of project description goes here

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them
eclipse, git bash , MYSQL,jira 
```

### Installing

A step by step series of examples that tell you how to get a development env running

Useable objects 
Customer
Order
Item 


Say what the step will be

Create 
open the terminal and in all caps enter the object you want to use then select the option you want in this case create in all caps. Finally input the information you want to add so for example if you were adding a customer you would input firstname,surname,username and passowrd.


Give the example
1	jordan	harrison	username	password

And repeat

update
the process is the same except instead of create enter UPDATE then unlike create it will ask for the primary key so for id of the item you want to update 

```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do

### Unit Tests 

Explain what these tests test, why and how to run them

there are several tests that need to be done for example method tests and then mockito tests that not only test the method but test how many times each data type is run for example
Give an example
	Mockito.when(utils.getString()).thenReturn(F_NAME, L_NAME,U_name,pass);
		Mockito.when(dao.create(created)).thenReturn(created);

### Integration Tests 
Explain what these tests test, why and how to run them
intergration tests are the things such as the sql data and how mysql affects the schema and data used for the database
```


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
