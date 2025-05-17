// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract Crowdfunding {
    address public creator;
    uint public fundingGoal;
    uint public totalRaised;
    mapping(address => uint) public contributions;

    constructor(uint _fundingGoal) {
        creator = msg.sender;
        fundingGoal = _fundingGoal;
    }

    function contribute() external payable {
        require(totalRaised < fundingGoal, "Funding goal reached");
        contributions[msg.sender] += msg.value;
        totalRaised += msg.value;
    }

    function withdraw() external {
        require(msg.sender == creator, "Only creator can withdraw");
        require(totalRaised >= fundingGoal, "Funding goal not reached");
        payable(creator).transfer(address(this).balance);
    }

    // DAO Voting (Advanced Feature)
    mapping(address => bool) public voters;
    uint public voteCount;
    uint public requiredVotes;

    function voteForMilestone() external {
        require(contributions[msg.sender] > 0, "Must be a contributor");
        require(!voters[msg.sender], "Already voted");
        voters[msg.sender] = true;
        voteCount++;
    }
}