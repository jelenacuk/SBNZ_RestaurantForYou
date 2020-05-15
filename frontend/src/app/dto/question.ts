export class Question {

    name: string;
    text: string;
    answers: string[];

    constructor(name: string, text: string, answers: string[]) {
        this.text = text;
        this.answers = answers;
        this.name = name;
    }
}
