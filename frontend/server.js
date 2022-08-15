// //Install express server    
// const express = require('express');

// const path = require('path');   

// const app = express();   

// // Serve only the static files form the dist directory    
// app.use(express.static(__dirname + '/dist'));

// app.get('/*', function(req,res) {  
//     res.sendFile(path.join(__dirname+'/dist/index.html'));   
// });  

// // Start the app by listening on the default Heroku port    
// app.listen(process.env.PORT || 8080);


var http = require('http');
 var fs = require('fs');
 var path = require('path');

 http.createServer(function (request, response) {

    console.log('request starting for ');
    console.log(request);

    var filePath = '.' + request.url;
    if (filePath == './')
        filePath = './index.html';

    console.log(filePath);
    var extname = path.extname(filePath);
    var contentType = 'text/html';
    switch (extname) {
        case '.js':
            contentType = 'text/javascript';
            break;
        case '.css':
            contentType = 'text/css';
            break;
    }

    path.exists(filePath, function(exists) {

        if (exists) {
            fs.readFile(filePath, function(error, content) {
                if (error) {
                    response.writeHead(500);
                    response.end();
                }
                else {
                    response.writeHead(200, { 'Content-Type': contentType });
                    response.end(content, 'utf-8');
                }
            });
        }
        else {
            response.writeHead(404);
            response.end();
        }
    });

 }).listen(process.env.PORT || 5000)

 console.log('Server running at http://127.0.0.1:5000/');