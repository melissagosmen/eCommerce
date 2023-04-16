import logo from './logo.svg';
import './App.css';
import {Button} from "@mui/material";
import CategoryList from "./views/CategoryList"
import {BrowserRouter, Route, Routes} from "react-router-dom";

function App() {
  return (
    <div className="App">
        <BrowserRouter>
            <Routes>
                <Route path={"/"} element={<CategoryList/>}/>
                <Route path={"/checkout"} element={<CategoryList/>}/>
            </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
