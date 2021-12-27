var mysql      = require('mysql');
var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'root',
  password : '960227',
  database : 'ediary'
});

connection.connect();
