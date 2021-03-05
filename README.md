# csv-to-json

This will ask 2 or 3 inputs from user in command line.

# run
Package the project
```
$ mvn package -Dmaven.test.skip=true
```

```
go to project folder
$ java -jar target/csv-to-json-0.0.1-SNAPSHOT.jar
```

Shows in command line 
This App expects two inputs: 
 1. Type of input. valid values are 'text' or 'file'. 
 2. If it is 'text' paste your text in csv format and enter 'end' after completing else enter absolute file path 
 
Example input for option file:

line1: file

lien2: ...../resources/persons.csv


```
file
...../resources/persons.csv
```

User can see output in command line.

Example input for option user text input:

line1: text

csv data start:

   first_name,surname,age,nationality,favourite_colour
   
   John,Keynes,29,British,red
   
   Sarah,Robinson,54,,blue
   
end line: end

```
text
first_name,surname,age,nationality,favourite_colour
John,Keynes,29,British,red
Sarah,Robinson,54,,blue
end
```

User can see output in command line.

