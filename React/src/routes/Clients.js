import Button from '../../src/components/Button';
import '../App.css';
import { Link } from "react-router-dom";
import React, { Component } from 'react';


class Clients extends Component {

    constructor(props) {
        super(props)

        this.state = {
            userId: window.location.href.split('/').pop()
        }

    }

    render() {
        return (
            <div className='options'>
                <h2>pdv Clients</h2>

                <Link to={`/MyDocument/${this.state.userId}`}>
                    <Button color='green' text='Mes Documents' />

                </Link>
                <Link to={`/DocumentsForClient/${this.state.userId}`}>
                    <Button color='green' text='Tout Les Documents De la Bibliothéque' />
                </Link>

            </div>
        )
    }



}
export default Clients
