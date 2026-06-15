import {apiClient} from './ApiClient';

export const executeBasicAuthService
 = (token) => apiClient.get(`/basicauth`, {
    headers : {
        Authorization: token
    }
 });

 export const executeJwtAuthenticateService
 = (username,password) => apiClient.post(`/authenticate`, {
    username,password
 });