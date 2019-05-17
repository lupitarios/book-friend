import React, {Component} from 'react';
//import Login from './components/Login';
import BookForm from './components/BookForm';
import MainList from './components/MainList';

import './App.css';

// here put the call to the webservice?

class App extends Component {

  state = {
    books: [{
      id : 1,  
      title : 'The Suicide Club',
      author : 'Robert Louis Stevenson', 
      bauthor : true, 
      chapters : 4, 
      stars : 5
    },
    {
      id : 2,  
      title : '1984',
      author : 'George Orwell', 
      bauthor : false, 
      chapters : 3, 
      stars : 4
    },{
      id : 3,  
      title : 'The Claming of the Sleeping Beauty',
      author : 'Anne Rice', 
      bauthor : true, 
      chapters : 7, 
      stars : 5
    }]
  };

  render(){
    return (
    <div className="App">
    <h3>Book Friend</h3>
  
     <MainList />
    </div>
  );
  }
  
}

export default App;
