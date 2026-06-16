import { useState } from 'react';
import './Counter.css';
import CounterButton from './CounterButton';
import PropTypes from 'prop-types';

export default function Counter(){


    const [count,setCount] = useState(0);

    function incrementParentFunction(by){
        setCount(count + by)
    }

    function decrementParentFunction(by){
        setCount(count - by)
    }

    function resetCounter(){
        setCount(0)
    }

    return (
        <>
            <span className='totalCount'>{count}</span>
            <CounterButton by={1} incrementMethod = {incrementParentFunction} decrementMethod = {decrementParentFunction} />
            <CounterButton by={2} incrementMethod = {incrementParentFunction} decrementMethod = {decrementParentFunction}/>
            <CounterButton by={5} incrementMethod = {incrementParentFunction} decrementMethod = {decrementParentFunction}/>
            <button className='resetButton' onClick={resetCounter}>Reset</button>

        </>
    )
}

Counter.propTypes = {
    by: PropTypes.number
};