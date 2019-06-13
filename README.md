# Discount-app
An application whose main task is to charge a discount to products in the amount proportional to their price.
## Description
The application allows you to send a discount and a list of products (min 1 max 5) along with prices, which are then proportionally calculated and returned to the customer in JSON format.
## To serve in the browser 
The application can be launched by the selected environment idea or using a command
<br/>
<br/>
``$ gradle bootRun``

The application will start on the port 8080

## How to use
Endpoints 

Method - GET: localhost:8080/products/discount

Example JSON

```json
{
	"discount": "100",
	"products": [
		
	{
		"name": "Product 1",
		"price": "1500"
	},
	
	{
		"name": "Product 2",
		"price": "500"
	
	}
	
	]
}
```

## Built With
 * Java 8
 * Spring Boot – Java framework
 * Loombok plugin
## Author
Szymon Ciamaga 
## License
This project is licensed under the MIT License.