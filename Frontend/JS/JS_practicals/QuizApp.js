/*
✅ 3. Create a Basic Quiz App
💡 Description:

Ask 3–5 multiple-choice questions. When user submits, show how many answers were correct.
🔧 Concepts:

    Radio buttons

    Event listeners

    DOM queries

    Score logic
*/
const fs = require('fs');
const path = require('path');
const { exec } = require('child_process');

const html = `
<!DOCTYPE html>
<html>
<head>
  <title>Simple Quiz</title>
  <style>
    body { font-family: Arial; padding: 20px; }
    button { padding: 10px; font-size: 16px; margin-top: 10px; }
  </style>
</head>
<body>
  <h2>Quiz</h2>
  <form id="quizForm">
    <p>1. 5 + 3 = ?</p>
    <input type="radio" name="q1" value="8">8<br>
    <input type="radio" name="q1" value="6">6<br>

    <p>2. Capital of India?</p>
    <input type="radio" name="q2" value="Delhi">Delhi<br>
    <input type="radio" name="q2" value="Mumbai">Mumbai<br>

    <p>3. 10 / 2 = ?</p>
    <input type="radio" name="q3" value="5">5<br>
    <input type="radio" name="q3" value="2">2<br>

    <button type="button" onclick="checkQuiz()">Submit</button>
  </form>
  <p id="result"></p>

  <script>
    function checkQuiz() {
      const answers = {
        q1: '8',
        q2: 'Delhi',
        q3: '5'
      };
      let score = 0;
      for (let key in answers) {
        const selected = document.querySelector('input[name="'+key+'"]:checked');
        if (selected && selected.value === answers[key]) score++;
      }
      document.getElementById('result').innerText = 'You got ' + score + '/3 correct.';
    }
  </script>
</body>
</html>
`;

const filePath = path.join(__dirname, 'quiz.html');
fs.writeFileSync(filePath, html);
exec(process.platform === 'win32' ? `start "" "${filePath}"` : process.platform === 'darwin' ? `open "${filePath}"` : `xdg-open "${filePath}"`);
