/*
✅ 5. Create a Live Character Counter
💡 Description:

Create a text box and show how many characters have been typed (like Twitter). Warn if the user exceeds a limit.
🔧 Concepts:

    input event listener

    String .length

    Updating inner text dynamically
*/    
const fs = require('fs');
const path = require('path');
const { exec } = require('child_process');

const html = `
<!DOCTYPE html>
<html>
<head>
  <title>Character Counter</title>
  <style>
    body { font-family: Arial; padding: 20px; }
    textarea { width: 100%; height: 100px; font-size: 16px; padding: 10px; }
  </style>
</head>
<body>
  <h2>Live Character Counter</h2>
  <textarea id="text" maxlength="100" placeholder="Type here..."></textarea>
  <p id="counter">0 / 100</p>

  <script>
    const textarea = document.getElementById('text');
    const counter = document.getElementById('counter');

    textarea.addEventListener('input', () => {
      const len = textarea.value.length;
      counter.textContent = len + ' / 100';
    });
  </script>
</body>
</html>
`;

const filePath = path.join(__dirname, 'charcount.html');
fs.writeFileSync(filePath, html);
exec(process.platform === 'win32' ? `start "" "${filePath}"` : process.platform === 'darwin' ? `open "${filePath}"` : `xdg-open "${filePath}"`);
