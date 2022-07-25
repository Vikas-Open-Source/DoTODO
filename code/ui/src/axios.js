import axios from 'axios';

const API_BASE = 'http://localhost:9099';

const axiosInstance = axios.create({
    baseURL: API_BASE,
    headers: {
      'Content-type': 'application/json',
      'Access-Control-Allow-Origin': '*'
    }
  });

export default axiosInstance;