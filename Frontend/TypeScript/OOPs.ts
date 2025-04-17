//OOPS Concepts
class Person{
    name:string;
    constructor(name:string){
        this.name=name;
    }

    greet():void{
        console.log(`Hello ${this.name}`);
    }
}

const person1=new Person("Anirudha");
person1.greet();

// Inheritance
 class Employee extends Person{
    empId:number;
    constructor(name:string,empId:number){
        super(name);
        this.empId=empId;
    }
    display():void{
        console.log('${this.name} has ID ${this.empId}' )
    }
 }

 class BankAccount1{
    private balance:number=0;
    deposit(amount:number):void{
        if(amount>0){
            this.balance +=amount;
        }
    }

    getBalance():number{
        return this.balance;
    }
 }

 abstract class Shape{
    abstract getArea():number;
 }

 class Circle extends Shape{
    constructor(public radius:number){
        super();
    }
    getArea(): number {
        return Math.PI * this.radius * this.radius;
    }
 }

 /* Create Banking System using TypeScript to perform banking operation 
 using OOPs concepts */