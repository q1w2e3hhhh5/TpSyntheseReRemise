import axios from 'axios';

const CLIENTS_API_BASE_URL = "http://localhost:8085/api/v1/Clients";
const EMPLOYEES_API_BASE_URL = "http://localhost:8085/api/v1/Employees";
const BOOK_API_BASE_URL = "http://localhost:8085/api/v1/Book";
const DOCUMENTS_API_BASE_URL = "http://localhost:8085/api/v1/Documents";
const CLIENT_API_BASE_URL = "http://localhost:8085/api/v1/Client";
const BORROWS_API_BASE_URL = "http://localhost:8085/api/v1/Borrows";

class EmployeeService {

    getClients() {
        return axios.get(CLIENTS_API_BASE_URL)
    }

    getEmployees() {
        return axios.get(EMPLOYEES_API_BASE_URL)
    }

    createClient(client) {
        return axios.post(CLIENTS_API_BASE_URL, client);
    }

    createBook(book) {
        return axios.post(BOOK_API_BASE_URL, book)
    }

    createDvd(dvd) {
        return axios.post(BOOK_API_BASE_URL, dvd)
    }

    createCd(cd) {
        return axios.post(BOOK_API_BASE_URL, cd)
    }

    getDocuments() {
        return axios.get(DOCUMENTS_API_BASE_URL);
    }

    getDocumentById(id) {
        return axios.get(DOCUMENTS_API_BASE_URL + '/' + id)
    }

    getClientById(id) {
        return axios.get(CLIENT_API_BASE_URL + '/' + id)
    }

    updateClient(client, clientId) {
        return axios.put(CLIENT_API_BASE_URL + '/' + clientId, client)
    }

    updateDocument(document, documentId) {
        return axios.put(DOCUMENTS_API_BASE_URL + '/' + documentId, document)
    }

    getBorrowsByClientId(id) {
        return axios.get(BORROWS_API_BASE_URL + '/' + id)
    }

    borrowDocument(userId, document) {
        return axios.post(BORROWS_API_BASE_URL + '/' + userId, document)
    }

    deleteDocument(id) {
        return axios.delete(BORROWS_API_BASE_URL + '/' + id)
    }


}

export default new EmployeeService()