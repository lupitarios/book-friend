import React, {Component} from 'react'
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

class MainList extends Component {
    
    render(){
        return (
            <Form>
                <Row>
                    <Col sm={2}>
                    <Button> New book </Button>
                    </Col>
                </Row>

                <Row>
                    <Col>
                        <Form.Label>Picture</Form.Label>
                    </Col>
                    <Col>
                        <Form.Group>
                            <Row>
                                <Form.Label column>Book's Name</Form.Label>
                            </Row>
                            <Row>
                                <Form.Label column>Book's Author</Form.Label>
                            </Row>
                            <Row>
                                <Form.Label column sm={5}>Chapter 
                                    <Form.Control as="select">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </Form.Control>
                                    Out of N
                                </Form.Label>
                            </Row>
                        </Form.Group>
                    </Col>
                    <Col>
                        <Form.Label>Favorite Quotes</Form.Label>
                    </Col>
                    <Col>
                        <Form.Label>Notes</Form.Label>
                    </Col>
                    <Col>
                        <Button> Delete </Button>
                    </Col>
                </Row>
            </Form>
        );
    }
}

export default MainList;