const fs = require('fs');
const { exec } = require('child_process');
const path = require('path');

// Step 1: Define nested company object
const company = {
  name: "TechNova Solutions Pvt. Ltd.",
  divisions: [
    {
      name: "Research & Development",
      teamLeader: "Dr. Aarti Sharma",
      employees: ["Rajesh", "Sneha", "Anil", "Fatima"]
    },
    {
      name: "Software Engineering",
      teamLeader: "Mr. Kunal Joshi",
      employees: ["Pooja", "Siddharth", "Meena", "Vivek"]
    },
    {
      name: "Marketing",
      teamLeader: "Ms. Priya Kapoor",
      employees: ["Ravi", "Anita"]
    }
  ]
};

// Step 2: Generate HTML content using semantic elements
let htmlContent = `
<!DOCTYPE html>
<html>
<head>
  <title>${company.name}</title>
  <style>
    body { font-family: sans-serif; margin: 20px; background: #f5f5f5; }
    header { background-color: #333; color: white; padding: 10px; }
    section { margin-top: 20px; background: white; padding: 15px; border-radius: 8px; box-shadow: 0 0 5px rgba(0,0,0,0.1); }
    h2 { color: #333366; }
    ul { padding-left: 20px; }
    article { margin-bottom: 15px; }
  </style>
</head>
<body>
  <header>
    <h1>${company.name}</h1>
  </header>
`;

company.divisions.forEach(division => {
  htmlContent += `
  <section>
    <h2>${division.name}</h2>
    <article>
      <strong>Team Leader:</strong> ${division.teamLeader}
    </article>
    <article>
      <strong>Employees:</strong>
      <ul>
        ${division.employees.map(emp => `<li>${emp}</li>`).join('')}
      </ul>
    </article>
  </section>
  `;
});

htmlContent += `
</body>
</html>
`;

// Step 3: Save and open the HTML file
const filePath = path.join(__dirname, 'company.html');
fs.writeFileSync(filePath, htmlContent);
console.log('✅ HTML file generated: company.html');

// Open in browser
const openCommand = process.platform === 'win32'
  ? `start "" "${filePath}"`
  : process.platform === 'darwin'
  ? `open "${filePath}"`
  : `xdg-open "${filePath}"`;

exec(openCommand, (err) => {
  if (err) {
    console.error('❌ Failed to open browser:', err);
  } else {
    console.log('🌐 Opened company.html in default browser.');
  }
});
