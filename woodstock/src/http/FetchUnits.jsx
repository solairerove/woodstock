import axios from 'axios';

const API_URL = 'http://localhost:9090/api';

export default class FetchUnits {
    static fetchUnits() {
        return axios
            .get(`${API_URL}/units`)
            .then(res => res.data)
            .catch(error => error);
    }
}
