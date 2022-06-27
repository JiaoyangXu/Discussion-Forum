import React, { Component } from 'react'
import 'bootstrap/dist/css/bootstrap.min.css'
import { Dropdown, Navbar, Nav, Container, NavDropdown, Form, FormControl, Button, NavbarBrand  } from 'react-bootstrap';



export default class NavigationComponent extends Component {

    render() {
        return (
            <Navbar bg="light" expand="lg">
                <Navbar.Brand href="#home">University of Waterloo Discussion Board</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav>
                        <Form className="d-flex">
                            <FormControl
                                type="search"
                                placeholder="Search"
                                className="me-2"
                                aria-label="Search"
                            />
                            <Button variant="outline-success">Search</Button>
                        </Form>
                    </Nav>

                    <Nav className="ms-auto">
                        <Nav.Link href="/post-question">Post Your Question</Nav.Link>

                        <NavDropdown title="Login" id="basic-nav-dropdown">
                            <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.2">Another action</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        )
    }
}