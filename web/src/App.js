import React, { Component } from 'react';
import './App.css';

class App extends Component {
  render() {
    return <Board/>;
  }
}

class Board extends Component {

  constructor(props) {
    super(props);
    this.state = { board: this.createInitialBoard() };
  }

  createInitialBoard() {
    return [
      ["WR", "WN", "WB", "WQ", "WK", "WB", "WN", "WR"],
      ["WP", "WP", "WP", "WP", "WP", "WP", "WP", "WP"],
      [null, null, null, null, null, null, null, null],
      [null, null, null, null, null, null, null, null],
      [null, null, null, null, null, null, null, null],
      [null, null, null, null, null, null, null, null],
      ["BP", "BP", "BP", "BP", "BP", "BP", "BP", "BP"],
      ["BR", "BN", "BB", "BQ", "BK", "BB", "BN", "BR"],
    ];
  }

  render() {
    return (
      <table class="board">
        <Row row={this.state.board[0]}/>
        <Row row={this.state.board[1]}/>
        <Row row={this.state.board[2]}/>
        <Row row={this.state.board[3]}/>
        <Row row={this.state.board[4]}/>
        <Row row={this.state.board[5]}/>
        <Row row={this.state.board[6]}/>
        <Row row={this.state.board[7]}/>
      </table>
    );
  }
}

function Row(props) {
  return (
    <tr class="row">
      <Square square={props.row[0]}/>
      <Square square={props.row[1]}/>
      <Square square={props.row[2]}/>
      <Square square={props.row[3]}/>
      <Square square={props.row[4]}/>
      <Square square={props.row[5]}/>
      <Square square={props.row[6]}/>
      <Square square={props.row[7]}/>
    </tr>
  );
}

function Square(props) {
  return <td class="square">{props.square}</td>;
}

export default App;
