import React, { Component } from 'react';
import EmployeeService from '../services/EmployeeService';
import '../App.css'
import Button from './Button';

class MyDocuments extends Component {

    constructor(props) {
        super(props)

        this.state = {
            documents: []
        }

        this.deleteDocument = this.deleteDocument.bind(this);

    }

    componentDidMount() {
        EmployeeService.getBorrowsByClientId(window.location.href.split('/').pop())
            .then((res) => {
                this.setState({ documents: res.data });
            });
    }


    deleteDocument(id) {
        console.log(id);

        EmployeeService.deleteDocument(id).then(res => {
            this.setState({ documents: this.state.documents.filter(document => document.id !== id) });
        })
    }

    render() {
        return (
            <>
                <div className='options'>
                    <div class="container">
                        <h2>Liste De Document</h2>
                        <ul class="responsive-table">
                            <li class="table-header">
                                <div class="col col-1">Titre</div>
                                <div class="col col-2">Anné de Publication</div>
                                <div class="col col-2">Auteur</div>
                                <div class="col col-2">Editeur</div>
                                <div class="col col-2">Categorie</div>
                                <div class="col col-2">Type De Document</div>
                                <div class="col col-2">Qunatité</div>
                                <div class="col col-2">Limite De Semaine D'Emprunt</div>
                                <div class="col col-2">Action</div>
                            </li>
                            <div>
                                {this.state.documents.map(
                                    document => <li className='table-row' key={document.id}>
                                        <div class="col col-1" > {document.title} </div>
                                        <div class="col col-2" >{document.publicationYear}</div>
                                        <div class="col col-2" >{document.author}</div>
                                        <div class="col col-2" >{document.editor}</div>
                                        <div class="col col-2" >{document.category}</div>
                                        <div class="col col-2" >{document.documentType}</div>
                                        <div class="col col-2" >{document.quantity}</div>
                                        <div class="col col-2" >{document.borrowTRimePeriod}</div>
                                        <div class="col col-2" >
                                            <Button color='red' text='Return' onClick={() => this.deleteDocument(document.id)} />
                                        </div>
                                    </li>
                                )}
                            </div>
                        </ul>
                    </div>
                </div>
            </>
        )
    }
}

export default MyDocuments