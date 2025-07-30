/*
✅ 1. Create a Temperature Converter
💡 Description:

Build a page that takes input in Celsius or Fahrenheit, and converts it to the other unit.
🔧 Concepts:

    DOM manipulation

    Event handling

    Input validation

    parseFloat(), basic math
*/
const fs = require('fs');
const path = require('path');
const { exec } = require('child_process');

const html = `
<!DOCTYPE html>
<html>
<head>
  <title>Temperature Converter</title>
  <style>
    body { font-family: Arial; padding: 20px; }
    input, select, button { padding: 10px; font-size: 16px; }
  </style>
</head>
<body>
  <h2>Temperature Converter</h2>
  <input id="tempInput" type="number" placeholder="Enter temperature">
  <select id="unit">
    <option value="C">Celsius to Fahrenheit</option>
    <option value="F">Fahrenheit to Celsius</option>
  </select>
  <button onclick="convert()">Convert</button>
  <p id="result"></p>

  <script>
    function convert() {
      const temp = parseFloat(document.getElementById('tempInput').value);
      const unit = document.getElementById('unit').value;
      let result = '';
      if (!isNaN(temp)) {
        if (unit === 'C') {
          result = (temp * 9/5 + 32).toFixed(2) + ' °F';
        } else {
          result = ((temp - 32) * 5/9).toFixed(2) + ' °C';
        }
      } else {
        result = 'Please enter a valid number';
      }
      document.getElementById('result').innerText = 'Result: ' + result;
    }
  </script>
</body>
</html>
`;

const filePath = path.join(__dirname, 'temperature.html');
fs.writeFileSync(filePath, html);
exec(process.platform === 'win32' ? `start "" "${filePath}"` : process.platform === 'darwin' ? `open "${filePath}"` : `xdg-open "${filePath}"`);
