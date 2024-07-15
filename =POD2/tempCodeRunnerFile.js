// Require the Express.js module and assign it to the variable 'express'
const express = require('express');

// Create an Express application instance
const app = express();

// Require the built-in 'path' module to handle file paths
const path = require('path');

// Require the built-in 'fs' module to handle file system operations
const fs = require('fs');

// Require the built-in 'child_process' module to spawn child processes
const childProcess = require('child_process');

// Require the 'passport' module for authentication
const passport = require('passport');

// Require the 'passport-local' module for local authentication strategy
const localStrategy = require('passport-local');

// Require the 'sql-client' module for SQL database operations
const sql = require('sql-client');

// Define a route for handling GET requests to '/search'
app.get('/search', (req, res, next) => {
    // Extract query parameters from the request object
    const { q, file, mode } = req.query;

    // Check the mode of operation
    if(mode === 'read'){
        console.log('read');
	console.log(file);
        // Check if the requested file is safe to read
        if(file.indexOf('./') === -1){
		console.log('readfile');
            // Read file contents synchronously
            file_contents = fs.readFileSync(path.join(__dirname, 'searchable', req.query.file));
            console.log(file_contents);
            // Check if the query string exists in the file contents
            if(file_contents.indexOf(q)){
		console.log('sending file');
                // Construct the file path and send the file as a response
                searchPath=path.join(__dirname,'searchable',req.query.file);
		console.log(searchPath);
                res.sendFile(searchPath);
            }
        } else {
            // Respond with a message indicating an attempted hack
	    console.log('hack')
            res.send('<h1>YOU TRYNA HACK ME BRUH?</h1>')
        }
    } else if(mode === 'write'){
	console.log('write');
        // Write data to a file asynchronously
        fs.writeFile(path.join(__dirname, 'searchable', req.query.file), req.query.q, () => {
            // Respond with a confirmation message
            res.send('Query in progress!');
        });
    } else if(mode === 'execute') {
	console.log('execute');
        // Execute a JavaScript file and send the result
        const myFile = require('./searchable/' + file);
        result = myFile();
        res.send('File run ' + result);
    } else {
	console.log('file mode')
        // Respond with an error if the mode is not specified or recognized
        res.status(400).send('File mode must be set!');
    }
});

// Define a route for handling GET requests to the root path '/'
app.get('/', (req,res)=>{
    // Send the index.html file as a response
    res.sendFile(path.join(__dirname, 'index.html'));
});

// Define a route for handling GET requests to '/water'
app.get('/water',(req,res)=>{
    // Send the penguinpage.html file as a response
    res.sendFile(path.join(__dirname,'penguinpage.html'));
});

// Define a route for handling GET requests to '/secretpath'
app.get('/secretpath', (req,res)=>{
    // Send the secret.html file as a response
    res.sendFile(path.join(__dirname,'secret.html'));
});

// Define a route for handling GET requests to '/robots.txt'
app.get('/robots.txt',(req,res)=>{
    // Send the robots.txt file as a response
    res.sendFile(path.join(__dirname, 'robots.txt'));
});

// Serve static files from the root directory
app.use(express.static(path.join(__dirname, '/')));

// Start the server and listen on port 12000
app.listen(12000, () =>{
    console.log('Chilling on port 12000');
});
