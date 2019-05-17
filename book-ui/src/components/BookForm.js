import React, {Component} from 'react'
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import FormGroup from 'react-bootstrap/FormGroup';
import StarRatingComponent from 'react-star-rating-component';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

class BookForm extends Component {

    constructor() {
    super();
 
    this.state = {
      rating: 1,
      validated: true 
        };
    }

    handleSubmit(event) {
    const form = event.currentTarget;
    if (form.checkValidity() === false) {
      event.preventDefault();
      event.stopPropagation();
    }
    this.setState({ validated: true });
  }

    onStarClick(nextValue, prevValue, name) {
    this.setState({rating: nextValue});
    }

    render(){
    const { rating } = this.state.rating;
    const { validated } = this.state.validated;

    return (
        <Form
        noValidate
        validated={validated}
        onSubmit={e => this.handleSubmit(e)}
        >
            <Form.Group as={Row} controlId="formBookName">
                <Form.Label column sm={2}>Book's name: </Form.Label>
                <Col sm="10">
                    <Form.Control required type="text" placeholder="Enter the Book's name" />
                </Col>
            </Form.Group>
            <Form.Group as={Row} controlId="formBookAuthor">
                <Form.Label column sm={2}>Book's Author: </Form.Label>
                <Col sm="10">
                    <Form.Control required type="text" placeholder="Enter the Book's Author" />
                </Col>
            </Form.Group>
            <Form.Group as={Row} controlId="formBookChapters">
                <Form.Label column sm={2}>Chapter's number: </Form.Label>
                <Col sm="10">
                    <Form.Control as="select" required>
                        <option>Choose...</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </Form.Control>
                </Col>
            </Form.Group>
            <Form.Group as={Row} controlId="formBookChapters">
                <Form.Label column sm={2}>How much interest do you have in this book?: </Form.Label>
                <Col sm="10">
                    <StarRatingComponent 
                    
                    name="bookInterest" 
                    starCount={5}
                    value={rating}
                    onStarClick={this.onStarClick.bind(this)}
                    />
                </Col>
            </Form.Group>
            <Form.Group as={Row} controlId="formBookBAuthor">
                <Form.Label column sm={2}>Have you read more books of this author?: </Form.Label>
                <Col sm="10">
                    <Form.Group >
                        <Form.Check
                        type="radio"
                        label="Yes"
                        name="formHorizontalRadios"
                        id="formHorizontalRadiosYes"
                        />
                        <Form.Check
                        type="radio"
                        label="No"
                        name="formHorizontalRadios"
                        id="formHorizontalRadiosNo"
                        />
                    </Form.Group>
                </Col>
            </Form.Group>
            <Form.Group as={Row} controlId="formBookLocationBook">
                <Form.Label column sm={2}>Where did you find it?: </Form.Label>
                <Col sm="10">
                    <Form.Control as="select" required>
                        <option>On a street market</option>
                        <option>It was a gift</option>
                        <option>In a Book Store</option>
                        <option>In a Mall</option>
                        <option>Online</option>
                        <option>Other</option>
                    </Form.Control>
                </Col>
            </Form.Group>
            <Button  type="submit">
                Submit
            </Button>
        </Form>
    );
   }
}

//export default BookForm;