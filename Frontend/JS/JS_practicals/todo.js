const fs = require('fs');
const { exec } = require('child_process');
const path = require('path');

// HTML content
const htmlContent = `
<!DOCTYPE html>
<html>
<head>
  <title>Simple To-Do List</title>
  <style>
    body { font-family: Arial; margin: 20px; }
    input[type="text"] { padding: 8px; width: 200px; }
    ul { padding-left: 20px; }
    li { margin-top: 5px; }
  </style>
</head>
<body>
  <h1>To-Do List</h1>
  <input id="taskInput" type="text" placeholder="Add a new task">
  <button onclick="addTask()">Add</button>
  <ul id="taskList"></ul>

  <script>
    function addTask() {
      const input = document.getElementById('taskInput');
      const task = input.value.trim();
      if (task !== "") {
        const li = document.createElement('li');
        li.textContent = task;
        document.getElementById('taskList').appendChild(li);
        input.value = "";
      }
    }
  </script>
</body>
</html>
`;

// Write HTML file
const filePath = path.join(__dirname, 'todo.html');
fs.writeFileSync(filePath, htmlContent);
console.log('✅ To-Do HTML generated: todo.html');

// Open in default browser
const openCommand = process.platform === 'win32'
  ? `start "" "${filePath}"`
  : process.platform === 'darwin'
  ? `open "${filePath}"`
  : `xdg-open "${filePath}"`;

exec(openCommand, (err) => {
  if (err) {
    console.error('❌ Failed to open the browser:', err);
  } else {
    console.log('🌐 Opened todo.html in your default browser.');
  }
});
