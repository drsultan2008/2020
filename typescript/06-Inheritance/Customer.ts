export class Customer {
    constructor(private _firstName: string , private _lastName: string){
    }

    public get firstName(): string{
        return this._firstName;
    }

    public set firstName(firstName: string){
        this._firstName = firstName;
    }

    public get lastName(): string{
        return this._lastName;
    }

    public set lastName(lastName: string){
        this._lastName = lastName;
    }
}

let myCustomer = new Customer("Pham","Hien");

console.log(myCustomer.firstName);