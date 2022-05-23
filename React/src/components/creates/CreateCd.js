import React, { Component } from 'react';
import Button from '../Button';
import { Link } from "react-router-dom";
import EmployeeService from '../../services/EmployeeService';
import '../../App.css';

class CreateCd extends Component {
    constructor(props) {
        super(props)

        this.state = {
            title: "",
            publicationYear: "",
            author: "",
            editor: "",
            category: "",
            documentType: "Cd",
            quantity: "",
            borrowTimePeriod: "1",
            timeLength: ""

        }

        this.changeTitleHandler = this.changeTitleHandler.bind(this);
        this.changePublicationYearHandler = this.changePublicationYearHandler.bind(this);
        this.changeAuthorHandler = this.changeAuthorHandler.bind(this);
        this.changeEditorHandler = this.changeEditorHandler.bind(this);
        this.changeCategoryHandler = this.changeCategoryHandler.bind(this);
        this.changeQuantityHandler = this.changeQuantityHandler.bind(this);
        this.changeTimeLengthHandler = this.changeTimeLengthHandler.bind(this);

        this.saveCd = this.saveCd.bind(this);
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

    changeTimeLengthHandler = (event) => {
        this.setState({ timeLength: event.target.value });
    }


    saveCd = (e) => {
        e.preventDefault();
        let cd = {
            title: this.state.title, publicationYear: this.state.publicationYear,
            author: this.state.author, editor: this.state.editor,
            category: this.state.category, quantity: this.state.quantity,
            timeLength: this.state.timeLength
        };
        console.log("cd=>" + JSON.stringify(cd))

        EmployeeService.createDvd(cd).then(res => {
            this.props.history.push("/Cd");
        });

        alert("Le document à été Crée")

    }

    render() {
        return (
            <>
                <div className='options'>
                    <div>
                        <h3>Ajouter Cd</h3>
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
                                <label>Duré:</label>
                                <input placeholder='0' name='timeLength'
                                    value={this.state.timeLength} onChange={this.changeTimeLengthHandler} />
                            </div>
                        </form>
                        <Button color='green' text='Save' onClick={this.saveCd} />
                        <Link to={`/Employees`}><Button color='red' text='Annuler' /></Link>
                    </div>
                </div>
            </>
        )
    }
}


export default CreateCd