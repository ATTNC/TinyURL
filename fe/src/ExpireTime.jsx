import { useState } from 'react';
import './ExpireTime.css'

function ExpireTime() {
    const [isOpen, setIsOpen] = useState(false);
    const [selectedOption, setSelectedOption] = useState("Choose Expire Time");

    const toggleDropdown = () => {
        setIsOpen(!isOpen);
    };

    const handleOptionClick = (option) => {
        setSelectedOption(option);
        setIsOpen(false);
    };

    console.log(isOpen)

    return (
        <div className="dropdown">
            <button onClick={toggleDropdown} className="dropdown-toggle">
                {selectedOption}
            </button>
            {isOpen && (
                <ul className="dropdown-menu">
                    <li onClick={() => handleOptionClick("None")}>None</li>
                    <li onClick={() => handleOptionClick("1 Minute")}>1 Minute</li>
                    <li onClick={() => handleOptionClick("5 Minutes")}>5 Minutes</li>
                    <li onClick={() => handleOptionClick("15 Minutes")}>15 Minutes</li>
                    <li onClick={() => handleOptionClick("1 Hour")}>1 Hour</li>
                    <li onClick={() => handleOptionClick("3 Hour")}>3 Hour</li>
                    <li onClick={() => handleOptionClick("12 Hour")}>12 Hour</li>
                    <li onClick={() => handleOptionClick("1 Day")}>1 Day</li>
                    <li onClick={() => handleOptionClick("1 Week")}>1 Week</li>
                    <li onClick={() => handleOptionClick("1 Year")}>1 Year</li>
                    <li onClick={() => handleOptionClick("Custom")}>Custom</li>
                </ul>
            )}
        </div>
    );
}

export default ExpireTime;
