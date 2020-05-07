export class WorkingDayDto {

    day: string;
    openingTime: string;
    closingTime: string;
    open: boolean;

    constructor(day: string) {
        this.day = day;
        this.open = true;
        this.openingTime = '00:00';
        this.closingTime = '00:00';
    }
}