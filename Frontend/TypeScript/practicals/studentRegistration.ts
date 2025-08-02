interface Person {
  getDetails(): string;
}

class Student implements Person {
  constructor(
    private name: string,
    private age: number,
    private course: string
  ) {}

  getDetails(): string {
    return `Name: ${this.name}, Age: ${this.age}, Course: ${this.course}`;
  }
}

function registerStudent() {
  const name = (document.getElementById('name') as HTMLInputElement).value;
  const age = parseInt((document.getElementById('age') as HTMLInputElement).value);
  const course = (document.getElementById('course') as HTMLInputElement).value;

  const student = new Student(name, age, course);
  document.getElementById('studentInfo')!.innerText = student.getDetails();
}
