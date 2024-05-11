// Functions in JavaScript

//  Functions are blocks of code that perform a specific task.
//  They are declared using the `function` keyword, followed by the function name and parameters (if any):

// javascript
function myFunction(parameter1, parameter2) {
  // Function body
}


//  Functions can be invoked by calling their name followed by any necessary parameters:

// javascript
// myFunction(arg1, arg2);


//  Functions can return values using the `return` statement:

// javascript
function sum(a, b) {
  return a + b;
}

console.log(sum(2, 5)); // 7


// Events in JavaScript

//  Events are occurrences that trigger the execution of specific event handlers.
//  Event handlers are functions that handle these events.
//  To add an event handler to an element, you use the `addEventListener()` method:

// javascript
// element.addEventListener('event_name', event_handler);


//  For example, to add a click event handler to a button:

// javascript
const button1 = document.querySelector('button');
button1.addEventListener('click', () => {
  console.log('Button clicked!');
});


//  When a specified event occurs, the event handler function is executed.

// Example: Combining Functions and Events

// javascript
function greetUser(name) {
  console.log(`Hello, ${name}!`);
}

const button2 = document.querySelector('button');
button2.addEventListener('click', () => {
  const name = prompt('Enter your name:');
  greetUser(name);
});


// In this example, the `greetUser()` function displays a greeting message based on a provided name. When the user clicks the button, an event handler is triggered which prompts the user for their name, and then calls the `greetUser()` function with the name as an argument.