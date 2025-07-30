/*
✅ 2. Create a BMI Calculator
💡 Description:

Create a simple form that asks for weight (kg) and height (cm), and calculates BMI with health category (underweight, normal, overweight, obese).
🔧 Concepts:

    Conditionals (if, else)

    Form handling

    DOM updates
*/
const fs = require('fs');
const path = require('path');
const { exec } = require('child_process');

const html = `
<!DOCTYPE html>
<html>
<head>
  <title>BMI Calculator</title>
  <style>
    body { font-family: Arial; padding: 20px; }
    input, button { padding: 10px; font-size: 16px; margin: 5px; }
  </style>
</head>
<body>
  <h2>BMI Calculator</h2>
  <input id="weight" type="number" placeholder="Weight (kg)">
  <input id="height" type="number" placeholder="Height (cm)">
  <button onclick="calculateBMI()">Calculate</button>
  <p id="result"></p>

  <script>
    function calculateBMI() {
      const weight = parseFloat(document.getElementById('weight').value);
      const height = parseFloat(document.getElementById('height').value) / 100;
      if (!isNaN(weight) && !isNaN(height) && height > 0) {
        const bmi = weight / (height * height);
        let category = '';
        if (bmi < 18.5) category = 'Underweight';
        else if (bmi < 24.9) category = 'Normal';
        else if (bmi < 29.9) category = 'Overweight';
        else category = 'Obese';

        document.getElementById('result').innerText = 'BMI: ' + bmi.toFixed(2) + ' (' + category + ')';
      } else {
        document.getElementById('result').innerText = 'Please enter valid values';
      }
    }
  </script>
</body>
</html>
`;

const filePath = path.join(__dirname, 'bmi.html');
fs.writeFileSync(filePath, html);
exec(process.platform === 'win32' ? `start "" "${filePath}"` : process.platform === 'darwin' ? `open "${filePath}"` : `xdg-open "${filePath}"`);
