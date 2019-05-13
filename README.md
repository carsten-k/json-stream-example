# Simple JSON output stream for Spring Boot

This is a very basic Spring Boot project that supports the streaming of large JSON arrays as a web service. It uses Jackson's ObjectMapper to serialize the objects into JSON.

This approach is useful if the Spring Application does not need to keep the objects in memory. It works just like streaming the binary content of a file.

## Building

Clone this repository or download the ZIP file:
```
git clone https://github.com/corschdi/json-stream-example.git
```
Change to the project directory:
```
cd json-stream-example
```
Use maven to create an executable package:
```
mvn package
```

## Usage

### Starting Spring Boot

Run the generated jar:
```
java -jar target/json-stream-example-1.0.0.jar
```

### Example Request: Read multiple objects

Open up a browser and load the url [http://localhost:8080/cars/?collectionSize=10](http://localhost:8080/cars/?collectionSize=10).

You should see each JSON object loading one by one, until the end of the array is reached.

```
[
    {
        "id": 1,
        "color": "ORANGE",
        "dimensions": {
            "length": 488,
            "width": 232,
            "height": 163
        }
    },
    ...
]
```

### Example Request: Read a single object

Open up a browser and load the url [http://localhost:8080/cars/12](http://localhost:8080/cars/12).