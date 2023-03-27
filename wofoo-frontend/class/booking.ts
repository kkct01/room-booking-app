import { User } from './user';

export class Booking {

    private _id! : number;
    private _roomNumber! : string;
    private _description! : string;
    private _createdAt! : Date;
    private _startTime! : Date;
    private _endTime! : Date;
    private _user! : User

    public get roomNumber() {
        return this._roomNumber;
    }

    public set roomNumber(inputRoomNumber : string) {
        this._roomNumber = inputRoomNumber;
    }

    public get description() {
        return this._description;
    }

    public set description(inputDescription : string) {
        if(inputDescription.length == 0 || inputDescription == undefined) {
            throw new Error('Description must not be empty');            
        }
        this._description = inputDescription;
    }

    public get createdAt() {
        return this._createdAt;
    }

    public get startTime() {
        return this._startTime;
    }

    public set startTime(inputStartTime : Date) {
        this._startTime = inputStartTime;
    }

    public get endTime() {
        return this._endTime;
    }

    public set endTime(inputEndTime : Date) {
        this._endTime = inputEndTime;
    }

    public get User() {
        return this._user;
    }
}
