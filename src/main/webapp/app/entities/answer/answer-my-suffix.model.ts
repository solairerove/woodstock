export class AnswerMySuffix {
    constructor(
        public id?: number,
        public answer?: string,
        public correct?: boolean,
        public enable?: boolean,
        public questionId?: number,
    ) {
        this.correct = false;
        this.enable = false;
    }
}
