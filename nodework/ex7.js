//es6 의 라이브러리 Number
let a=12;
let b=23.0;
let c=12.6;

console.log(a+"는 정수인가?"+Number.isInteger(a));//true
console.log(b+"는 정수인가?"+Number.isInteger(b));//true
console.log(c+"는 정수인가?"+Number.isInteger(c));//false

let a1="NaN";
let b1=NaN;
let c1="안녕";
let d1=12;

console.log("es5 의 isNaN 은 숫자일경우 false,숫자가 아닐경우 true");
console.log("a1="+isNaN(a1));//true
console.log("b1="+isNaN(b1));//true
console.log("c1="+isNaN(c1));//true
console.log("d1="+isNaN(d1));//false

console.log("es6 의 Number.isNaN 은 정말 NaN 인경우에만 true");
//NaN 은 수식 오류가 있을경우 NaN 발생
console.log(12/"a");//NaN
console.log("a1="+Number.isNaN(a1));//false
console.log("b1="+Number.isNaN(b1));//true
console.log("c1="+Number.isNaN(c1));//false
console.log("d1="+Number.isNaN(d1));//false

console.log("=".repeat(30));
