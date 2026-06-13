export default function CounterButton({ by = 5 , incrementMethod , decrementMethod }) {

    function incrementFunction() {
        incrementMethod(by);
    }

    function decrementFunction() {
        decrementMethod(by);
    }

    return (
        <div className='Counter'>
            {/* <span className="count">{count}</span> */}
            <div>
                <button className="counterButton" onClick={incrementFunction}>
                    +{by}
                </button>
                <button className="counterButton" onClick={decrementFunction}>
                    -{by}
                </button>
            </div>
        </div>
    );
}