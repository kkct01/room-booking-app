import { Booking } from './booking';

export class User {
    private _id! : number;
    private _name! : string;
    private _password! : string;
    private _role! : string;
    private _bookings! : Booking[];

    public get name() {
        return this._name;
    }

    public set name(inputName : string) {
        if(inputName.length == 0) {
            throw new Error('User name must not be empty');
        }
        this._name = inputName;
    }

    public get password() {
        return this._password;
    }

    public set password(inputPassword : string) {
        if(inputPassword.length < 8 || inputPassword.length > 20) {
            throw new Error('Password length must be 8 to 20');
        }
        this._password = inputPassword;
    }

    public get role() {
        return this._role;
    }

    public set role(inputRole : string) {
        if(inputRole.length == 0) {
            throw new Error('Role must not be empty');
        }
        this._role = inputRole;
    }

    public get bookings() {
        return this._bookings;
    }
}





