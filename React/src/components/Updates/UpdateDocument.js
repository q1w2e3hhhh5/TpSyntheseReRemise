import React, { Component } from 'react';
import Button from '../Button';
import { Link } from "react-router-dom";
import EmployeeService from '../../services/EmployeeService';
import '../../App.css';

class UpdateClient extends Component {
    constructor(props) {
        super(props)

        this.state = {
            documentId: window.location.href.split('/').pop(),
            title: "",
            publicationYear: "",
            author: "",
            editor: "",
            category: "",
            documentType: "Book",
            quantity: "",
            borrowTimePeriod: "3"

        }

        this.changeTitleHandler = this.changeTitleHandler.bind(this);
        this.changePublicationYearHandler = this.changePublicationYearHandler.bind(this);
        this.changeAuthorHandler = this.changeAuthorHandler.bind(this);
        this.changeEditorHandler = this.changeEditorHandler.bind(this);
        this.changeCategoryHandler = this.changeCategoryHandler.bind(this);
        this.changeQuantityHandler = this.changeQuantityHandler.bind(this);

        this.updateDocument = this.updateDocument.bind(this);
    }


    componentDidMount() {
        EmployeeService.getDocumentById(window.location.href.split('/').pop()).then((res) => {
            let document = res.data;
            console.log("Doc=>" + JSON.stringify(document))
            this.setState({
                title: document.title,
                publicationYear: document.publicationYear,
                author: document.author,
                editor: document.editor,
                category: document.category,
                quantity: document.quantity

            });
        });

    }



    changeTitleHandler = (event) => {
        this.setState({ title: event.target.value });
    }

    changePublicationYearHandler = (event) => {
        this.setState({ publicationYear: event.target.value });
    }

    changeAuthorHandler = (event) => {
        this.setState({ author: event.target.value });
    }

    changeEditorHandler = (event) => {
        this.setState({ editor: event.target.value });
    }

    changeCategoryHandler = (event) => {
        this.setState({ category: event.target.value });
    }

    changeQuantityHandler = (event) => {
        this.setState({ quantity: event.target.value });
    }



    updateDocument = (e) => {
        e.preventDefault();
        let document = {
            title: this.state.title, publicationYear: this.state.publicationYear,
            author: this.state.author, editor: this.state.editor,
            category: this.state.category, quantity: this.state.quantity
        };
        console.log("Doc=>" + JSON.stringify(document))

        EmployeeService.updateDocument(document, this.state.documentId).then(res => {
            this.props.history.push("/Documents");
        });

        alert("Le document à été Crée")

    }

    render() {
        return (
            <>
                <div className='options'>
                    <div>
                        <h3>Modifier Document</h3>
                        <form>
                            <div className='block'>
                                <label>Titre:</label>
                                <input placeholder='titre' name='title'
                                    value={this.state.title} onChange={this.changeTitleHandler} />
                            </div>
                            <div className='block'>
                                <label>Année de publication:</label>
                                <input placeholder='0000' name='publicationYear'
                                    value={this.state.publicationYear} onChange={this.changePublicationYearHandler} />
                            </div>
                            <div className='block'>
                                <label>Auteur:</label>
                                <input placeholder='author' name='author'
                                    value={this.state.author} onChange={this.changeAuthorHandler} />
                            </div>
                            <div className='block'>
                                <label>Editeur:</label>
                                <input placeholder='editor' name='editor'
                                    value={this.state.editor} onChange={this.changeEditorHandler} />
                            </div>
                            <div className='block'>
                                <label>Categorie:</label>
                                <input placeholder='category' name='category'
                                    value={this.state.category} onChange={this.changeCategoryHandler} />
                            </div>
                            <div className='block'>
                                <label>Quantité:</label>
                                <input placeholder='quantity' name='quantity'
                                    value={this.state.quantity} onChange={this.changeQuantityHandler} />
                            </div>
                        </form>
                        <Button color='green' text='Enregistrer' onClick={this.updateDocument} />
                        <Link to={`/DocumentsForEmployee`}><Button color='red' text='Annuler' /></Link>
                    </div>
                </div>
            </>
        )
    }
}


export default UpdateClient