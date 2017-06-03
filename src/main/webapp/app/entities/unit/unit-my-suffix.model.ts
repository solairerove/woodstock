export class UnitMySuffix {
    constructor(
        public id?: number,
        public label?: string,
        public avatar?: string,
        public description?: string,
        public featured?: boolean,
        public modulesId?: number,
    ) {
        this.featured = false;
    }
}
