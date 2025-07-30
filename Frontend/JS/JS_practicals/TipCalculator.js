/*
✅ 4. Create a Tip Calculator
💡 Description:

Ask for the bill amount and tip percentage. Display the total tip and grand total.
🔧 Concepts:

    Math operations

    Real-time calculation on input

    Formatting numbers (e.g. .toFixed(2))
*/
const fs = require('fs');
const path = require('path');
const { exec } = require('child_process');

const html = `
<!DOCTYPE html>
<html>
<head>
  <title>Tip Calculator</title>
  <style>
    body { font-family: Arial; padding: 20px; }
    input, button { padding: 10px; font-size: 16px; margin: 5px; }
  </style>
</head>
<body>
  <h2>Tip Calculator</h2>
  <input id="amount" type="number" placeholder="Bill Amount">
  <input id="tip" type="number" placeholder="Tip %">
  <button onclick="calculateTip()">Calculate</button>
  <p id="result"></p>

  <script>
    function calculateTip() {
      const amt = parseFloat(document.getElementById('amount').value);
      const tip = parseFloat(document.getElementById('tip').value);
      if (!isNaN(amt) && !isNaN(tip)) {
        const tipAmount = amt * tip / 100;
        const total = amt + tipAmount;
        document.getElementById('result').innerText = 
          'Tip: ₹' + tipAmount.toFixed(2) + ', Total: ₹' + total.toFixed(2);
      } else {
        document.getElementById('result').innerText = 'Enter valid inputs';
      }
    }
  </script>
</body>
</html>
`;

const filePath = path.join(__dirname, 'tip.html');
fs.writeFileSync(filePath, html);
exec(process.platform === 'win32' ? `start "" "${filePath}"` : process.platform === 'darwin' ? `open "${filePath}"` : `xdg-open "${filePath}"`);
