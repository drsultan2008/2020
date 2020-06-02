var reviews = [1, 2, 3, 4, 6];
var total = 0;
// for (let i=0; i<reviews.length; i++){
//     console.log(reviews[i]);
//     total+=reviews[i];
// }
// let avg: number = total/reviews.length;
// console.log("Avg: "+ avg);
// for (let iter of reviews){
//     console.log(iter);
// }
var sportOne = ["Golf", "Cricket", "Tennis", "Swimming"];
sportOne.push("Baseball");
sportOne.push("Football");
for (var _i = 0, sportOne_1 = sportOne; _i < sportOne_1.length; _i++) {
    var iter = sportOne_1[_i];
    if (iter === "Golf") {
        console.log("My best: " + iter);
    }
    else {
        console.log(iter);
    }
}
