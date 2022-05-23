import React, { Component } from 'react';
import Button from '../Button';
import { Link } from "react-router-dom";
import EmployeeService from '../../services/EmployeeService';
import '../../App.css';

class CreateBook extends Component {
    constructor(props) {
        super(props)

        this.state = {
            title: "",
            publicationYear: "",
            author: "",
            editor: "",
            category: "",
            documentType: "Book",
            quantity: "",
            borrowTimePeriod: "3",
            nbPages: ""

        }

        this.changeTitleHandler = this.changeTitleHandler.bind(this);
        this.changePublicationYearHandler = this.changePublicationYearHandler.bind(this);
        this.changeAuthorHandler = this.changeAuthorHandler.bind(this);
        this.changeEditorHandler = this.changeEditorHandler.bind(this);
        this.changeCategoryHandler = this.changeCategoryHandler.bind(this);
        this.changeQuantityHandler = this.changeQuantityHandler.bind(this);
        this.changeNbPagesHandler = this.changeNbPagesHandler.bind(this);

        this.saveBook = this.saveBook.bind(this);
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

    changeNbPagesHandler = (event) => {
        this.setState({ nbPages: event.target.value });
    }


    saveBook = (e) => {
        e.preventDefault();
        let book = {
            title: this.state.title, publicationYear: this.state.publicationYear,
            author: this.state.author, editor: this.state.editor,
            category: this.state.category, quantity: this.state.quantity,
            nbPages: this.state.nbPages
        };
        console.log("Book=>" + JSON.stringify(book))

        EmployeeService.createBook(book).then(res => {
            this.props.history.push("/Book");
        });

        alert("Le document à été Crée")

    }

    render() {
        return (
            <>
                <div className='options'>
                    <div>
                        <h3>Ajouter livre</h3>
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
                            <div className='block'>
                                <label>Nombre de pages:</label>
                                <input placeholder='0' name='nbPages'
                                    value={this.state.nbPages} onChange={this.changeNbPagesHandler} />
                            </div>
                        </form>
                        <Button color='green' text='Save' onClick={this.saveBook} />
                        <Link to={`/Employees`}><Button color='red' text='Annuler' /></Link>
                    </div>
                </div>
            </>
        )
    }
}
export default CreateBook