let reviews: number[] = [1,2,3,4,6];
let total:number = 0;

// for (let i=0; i<reviews.length; i++){
//     console.log(reviews[i]);
//     total+=reviews[i];
// }

// let avg: number = total/reviews.length;

// console.log("Avg: "+ avg);

// for (let iter of reviews){
//     console.log(iter);
// }

let sportOne: string[] = ["Golf","Cricket","Tennis","Swimming"];

sportOne.push("Baseball");
sportOne.push("Football");

for (let iter of sportOne){
    if (iter === "Golf"){
        console.log("My best: "+iter);
    }
    else{
        console.log(iter);
    }
}

