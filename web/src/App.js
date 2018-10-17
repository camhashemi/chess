import React, { Component } from 'react';
import './App.css';

class App extends Component {
  render() {
    return <Board/>;
  }
}

class Board extends Component {
  render() {
    return (
      <table class="board">
        <Row/>
        <Row/>
        <Row/>
        <Row/>
        <Row/>
        <Row/>
        <Row/>
        <Row/>
      </table>
    );
  }
}

function Row() {
  return (
    <tr class="row">
      <Square/>
      <Square/>
      <Square/>
      <Square/>
      <Square/>
      <Square/>
      <Square/>
      <Square/>
    </tr>
  );
}

function Square() {
  return <td class="square"></td>;
}

export default App;
